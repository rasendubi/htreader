import {Component} from 'angular2/core';
import {Injectable} from 'angular2/core';
import {Extract} from './extract'

@Injectable()
export class ExtractsService {
    getExtracts() {
        return Promise.resolve([<Extract> {id: 1, title: "Shit", content: "Contents"}]);
    }
}

