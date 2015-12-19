import {bootstrap} from 'angular2/platform/browser';
import {enableProdMode} from 'angular2/core';
import {ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {AppComponent} from './app.component';
import {TextsService} from './texts.service';
import {ExtractsService} from './extracts.service';
import {CardsService} from './cards.service';

// enableProdMode();

bootstrap(AppComponent, [
    ROUTER_PROVIDERS,
    HTTP_PROVIDERS,
    TextsService,
    ExtractsService,
    CardsService
]);