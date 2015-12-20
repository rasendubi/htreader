import {Component, Injectable} from 'angular2/core';
import {Http, Headers} from 'angular2/http';
import {Extract} from './extract';

@Injectable()
export class ExtractsService {
    public selectionText = "";
    constructor(private _http: Http) { }

    getExtracts(): Promise<Extract[]> {
        return new Promise((resolve, reject) => {
            this._http.get('/api/extracts/scheduled').subscribe(value => resolve(<Extract[]> value.json()));
        });
    }

    rescheduleExtract(extract: Extract) {
        this._http.post(`/api/extract/${extract.id}`, "").subscribe();
    }

    deleteExtract(extract: Extract) {
        this._http.delete(`/api/extract/${extract.id}`).subscribe();
    }

    addExtract(extract: Extract) {
        const headers = new Headers();
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
        this._http.post(`/api/extract`, `text=${encodeURIComponent(extract.text)}&article=${extract.article}`, {headers})
            .subscribe();
    }
}

