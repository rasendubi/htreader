import {Component} from 'angular2/core';
import {Card} from './card';
import {CardsService} from './cards.service';

@Component({
    templateUrl: 'app/cards.component.html'
})
export class CardsComponent {
    public cards: Card[] = [];
    constructor(private _cardsService: CardsService) { }
    ngOnInit() {
        this._cardsService.getCards().then(cards => this.cards = cards);
    }

    selectedCard() {
        return this.cards[0];
    }

    setMark(value: Number) {
        this.cards.splice(0, 1);
    }
}