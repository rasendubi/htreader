import {Component, OnInit, AfterViewChecked} from 'angular2/core';
import {Card} from './card';
import {CardsService} from './cards.service';

@Component({
    templateUrl: 'app/cards.component.html',
    styleUrls: [
        'node_modules/bootstrap/dist/css/bootstrap.css',
        'app/cards.component.css'
    ]
})
export class CardsComponent implements OnInit, AfterViewChecked {
    public cards: Card[] = [];
    public userClickedOk = false;
    constructor(private _cardsService: CardsService) { }

    ngOnInit() {
        this._cardsService.getCards().then(cards => this.cards = cards);
    }

    ngAfterViewChecked() {
        if (this.selectedCard()) {
            if (this.userClickedOk) {
                document.getElementById("mark-btn-4").focus();
            } else {
                document.getElementById("ok-btn").focus();
            }
        }
    }

    selectedCard() {
        return this.cards[0];
    }

    okClicked() {
        this.userClickedOk = true;
    }

    setMark(value: Number) {
        this._cardsService.markCard(this.selectedCard().id, value);
        this.cards.splice(0, 1); // remove this card from the list
        this.userClickedOk = false;
    }
}