import {Component, OnInit} from 'angular2/core';
import {RouteParams, Router} from 'angular2/router';
import {ArticlesService} from './articles.service';
import {Article} from './article';

@Component({
    templateUrl: 'app/article.component.html',
    styleUrls: [
        'node_modules/bootstrap/dist/css/bootstrap.css',
        // 'app/article.component.css'
    ]
})
// export class ArticleComponent implements OnInit {
export class ArticleComponent {
    public article: Article = undefined;
    constructor(private _routeParams: RouteParams,
                private _router: Router,
                private _articlesService: ArticlesService) { }

    ngOnInit() {
        const articleId = parseInt(this._routeParams.get('id'), 10);
        this._articlesService.getArticle(articleId).then(article => this.article = article);
    }
}