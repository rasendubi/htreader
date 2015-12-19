import {Component, Injectable} from 'angular2/core';
import {Http} from "angular2/http";
import {Card} from './card'

@Injectable()
export class CardsService {
    constructor(private _http: Http) { }
    getCards() {
        return new Promise((resolve, reject) => {
            this._http.get('/api/cards').subscribe(value => resolve(<Card> value.json()));
        });
    }
}

