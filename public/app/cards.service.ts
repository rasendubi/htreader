import {Component, Injectable} from 'angular2/core';
import {Http} from "angular2/http";
import {Card} from './card'

@Injectable()
export class CardsService {
    constructor(private _http: Http) { }

    getCards(): Promise<Card[]> {
        return new Promise((resolve, reject) => {
            this._http.get('/api/cards/scheduled').subscribe(value => resolve(<Card[]> value.json()));
        });
    }

    addCard(card: Card) {
        this._http.post(`/api/card?question=${encodeURIComponent(card.question)}&`+
                `answer=${encodeURIComponent(card.answer)}`, "").subscribe();
    }

    markCard(id: number, mark: number) {
        this._http.post(`/api/card/${id}?quality=${mark}`, "").subscribe();
    }
}

