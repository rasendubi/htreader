import {Component, OnInit, AfterViewInit} from 'angular2/core';
import {Card} from './card';
import {CardsService} from './cards.service';

@Component({
    templateUrl: 'app/cards.component.html',
    styleUrls: [
        'node_modules/bootstrap/dist/css/bootstrap.css',
        'app/cards.component.css'
    ],
})
export class CardsComponent implements OnInit, AfterViewInit {
    public cards: Card[] = [];
    public userClickedOk = false;
    constructor(private _cardsService: CardsService) { }

    ngOnInit() {
        this._cardsService.getCards().then(cards => this.cards = cards);
    }

    ngAfterViewInit() {
        // document.getElementById("ok-btn").focus();
    }

    selectedCard() {
        return this.cards[0];
    }

    okClicked() {
        this.userClickedOk = true;
        document.getElementById("mark-btn-4").focus();
    }

    setMark(value: Number) {
        this.cards.splice(0, 1); // remove this card from the list
        this.userClickedOk = false;
    }
}