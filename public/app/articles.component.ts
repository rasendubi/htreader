import {Component, OnInit} from 'angular2/core';
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
    constructor(private _articlesService: ArticlesService) { }
    ngOnInit() {
        this._articlesService.getArticles().then(articles => this.articles = articles);
    }

    viewArticle(article: Article) {
        // todo
    }

    deleteArticle(article: Article) {

    }
}