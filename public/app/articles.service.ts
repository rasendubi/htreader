import {Component} from 'angular2/core';
import {Injectable} from 'angular2/core';
import {Article} from './article';
import {Http} from "angular2/http";

@Injectable()
export class ArticlesService {
    constructor(private _http: Http) { }

    getArticles(): Promise<Article[]> {
        return new Promise((resolve, reject) => {
            this._http.get('/api/articles').subscribe(value => resolve(<Article[]> value.json()));
        });
    }

    getArticle(id: Number): Promise<Article> {
        return new Promise((resolve, reject) => {
            this._http.get(`/api/article/${id}`).subscribe(value => resolve(<Article> value.json()));
        });
    }

    deleteArticle(article: Article) {
        this._http.delete(`/api/article/${article.id}`).subscribe();
    }

    addArticle(article: Article) {
        // todo
    }
}

