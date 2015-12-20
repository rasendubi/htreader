import {Component, OnInit} from 'angular2/core';
import {Router} from 'angular2/router';
import {ArticlesService} from './articles.service';
import {Article} from './article';

@Component({
    templateUrl: 'app/articles.component.html',
    styleUrls: [
        'node_modules/bootstrap/dist/css/bootstrap.css',
        'app/articles.component.css'
    ]
})
export class ArticlesComponent implements OnInit {
    public articles: Article[] = [];
    public newArticle: Article = {title: "", text: ""};

    constructor(private _articlesService: ArticlesService, private _router: Router) { }

    ngOnInit() {
        this._articlesService.getArticles().then(articles => this.articles = articles);
    }

    viewArticle(article: Article) {
        this._router.navigate(['Article', {id: article.id}]);
    }

    deleteArticle(article: Article) {
        this._articlesService.deleteArticle(article);
        this.articles.splice(this.articles.indexOf(article), 1);
    }

    addArticle() {
        const article: Article = {title: this.newArticle.title, text: this.newArticle.text};
        this.articles.push(article);

        this._articlesService.addArticle(article).then(id => article.id = id)
    }
}