import {Component, Injectable} from 'angular2/core';
import {Http, Headers} from 'angular2/http';
import {Article} from './article';

@Injectable()
export class ArticlesService {
    constructor(private _http: Http) { }

    getArticles(): Promise<Article[]> {
        return new Promise((resolve, reject) => {
            this._http.get('/api/articles').subscribe(value => resolve(<Article[]> value.json()));
        });
    }

    getArticle(id: number): Promise<Article> {
        return new Promise((resolve, reject) => {
            this._http.get(`/api/article/${id}`).subscribe(value => resolve(<Article> value.json()));
        });
    }

    deleteArticle(article: Article) {
        this._http.delete(`/api/article/${article.id}`).subscribe();
    }

    addArticle(article: Article): Promise<number> {
        return new Promise((resolve, reject) => {
            const headers = new Headers();
            headers.append('Content-Type', 'application/x-www-form-urlencoded');
            this._http.post(`/api/article`, `title=${encodeURIComponent(article.title)}` +
                                            `&text=${encodeURIComponent(article.text)}`+
                                            `&source=${encodeURIComponent(article.source)}`,
                                            {headers})
                .subscribe(value => resolve(<number> value.json().id));
        });
    }
}

