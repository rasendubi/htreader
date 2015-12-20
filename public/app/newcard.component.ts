import {Component, OnInit} from 'angular2/core';
import {RouteParams, Router} from 'angular2/router';
import {Card} from './Card';
import {CardsService} from './cards.service';

@Component({
    templateUrl: 'app/newcard.component.html',
    styleUrls: [
        'node_modules/bootstrap/dist/css/bootstrap.css',
        'app/newcard.component.css'
    ]
})
export class NewCardComponent implements OnInit {
    public card: Card = undefined;
    constructor(private _routeParams: RouteParams,
                private _router: Router,
                private _cardsService: CardsService) { }

    ngOnInit() {
        const question = this._routeParams.get('question');
        const extractId = parseInt(this._routeParams.get('extractId'), 10);
        this.card = {question, answer: "", extractId};
    }

    addCard() {
        this._cardsService.addCard(this.card);
        this._router.navigate(['Extracts']);
    }
}