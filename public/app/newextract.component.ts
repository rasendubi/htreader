import {Component, OnInit} from 'angular2/core';
import {RouteParams, Router} from 'angular2/router';
import {Extract} from './extract';
import {ExtractsService} from './extracts.service';

@Component({
    templateUrl: 'app/newextract.component.html',
    styleUrls: [
        'node_modules/bootstrap/dist/css/bootstrap.css',
        'app/newextract.component.css'
    ]
})
export class NewExtractComponent implements OnInit {
    public extract: Extract = {text: ""};
    constructor(private _routeParams: RouteParams,
                private _router: Router,
                private _extractsService: ExtractsService) { }

    ngOnInit() {
        const articleId = parseInt(this._routeParams.get('articleId'), 10);

        this.extract = {article: articleId, text: this._extractsService.selectionText};
    }

    addExtract() {
        const articleId = parseInt(this._routeParams.get('articleId'), 10);

        this._extractsService.addExtract(this.extract);
        this._router.navigate(['Article', {id: articleId}]);
    }
}
