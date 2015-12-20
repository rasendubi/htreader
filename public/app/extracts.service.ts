import {Component, Injectable} from 'angular2/core';
import {Http} from "angular2/http";
import {Extract} from './extract';

@Injectable()
export class ExtractsService {
    constructor(private _http: Http) { }

    getExtracts(): Promise<Extract[]> {
        return new Promise((resolve, reject) => {
            this._http.get('/api/extracts/scheduled').subscribe(value => resolve(<Extract[]> value.json()));
        });
    }

    rescheduleExtract(extract: Extract) {
        this._http.post(`/api/extract/${extract.id}`, "").subscribe();
    }
}

