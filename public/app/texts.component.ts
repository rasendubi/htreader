import {Component, OnInit} from 'angular2/core';
import {TextsService} from './texts.service'
import {Text} from './text'

@Component({
    templateUrl: 'app/texts.component.html'
})
export class TextsComponent implements OnInit { 
    public texts: Text[] = []; 
    constructor(private _textsService: TextsService) { }
    ngOnInit() {
        this._textsService.getTexts().then(texts => this.texts = texts);
    }
}