import {Component} from 'angular2/core';
import {Injectable} from 'angular2/core';
import {Text} from './text'

@Injectable()
export class TextsService {
    getTexts() {
        return Promise.resolve([<Text> {id: 1, title: "Shit", content: "Contents"}]);
    }
}

