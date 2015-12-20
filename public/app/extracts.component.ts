import {Component} from 'angular2/core';
import {Extract} from './extract';
import {ExtractsService} from './extracts.service';

@Component({
    templateUrl: 'app/extracts.component.html',
    styleUrls: [
        'node_modules/bootstrap/dist/css/bootstrap.css',
        'app/extracts.component.css'
    ]
})
export class ExtractsComponent {
    public extracts: Extract[] = [];
    constructor(private _extractsService: ExtractsService) { }

    ngOnInit() {
        this._extractsService.getExtracts().then(extracts => this.extracts = extracts);
    }

    rescheduleExtract(extract: Extract) {
        this._extractsService.rescheduleExtract(extract);
        this.extracts.splice(this.extracts.indexOf(extract), 1);
    }
}