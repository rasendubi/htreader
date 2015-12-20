import {Component} from 'angular2/core';
import {Router} from 'angular2/router';
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

    constructor(private _extractsService: ExtractsService, private _router: Router) { }

    ngOnInit() {
        this._extractsService.getExtracts().then(extracts => this.extracts = extracts);
    }

    rescheduleExtract(extract: Extract) {
        this._extractsService.rescheduleExtract(extract);
        this.extracts.splice(this.extracts.indexOf(extract), 1);
    }

    createCardFromExtract(extract: Extract) {
        this._router.navigate(['NewCard', {question: extract.text, extractId: extract.id}]);
    }

    deleteExtract(extract: Extract) {
        this._extractsService.deleteExtract(extract);
        this.extracts.splice(this.extracts.indexOf(extract), 1);
    }
}