import {Component} from 'angular2/core';
import {Injectable} from 'angular2/core';
import {Card} from './card'

@Injectable()
export class CardsService {
    getCards() {
        return Promise.resolve([<Card> {id: 1, title: "Shit", content: "Contents"}]);
    }
}

