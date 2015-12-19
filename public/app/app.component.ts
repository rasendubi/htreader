import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES} from 'angular2/router';
import {CardsComponent} from './cards.component';
import {ExtractsComponent} from './extracts.component';
import {TextsComponent} from './texts.component';

@Component({
    selector: 'ht-reader',
    templateUrl: 'app/app.component.html',
    styleUrls: [
        'node_modules/bootstrap/dist/css/bootstrap.css',
        'app/app.component.css'
    ],
    directives: [ROUTER_DIRECTIVES]
})
@RouteConfig([
  {path: '/cards', name: 'Cards', component: CardsComponent, useAsDefault: true},
  {path: '/extracts', name: 'Extracts', component: ExtractsComponent},
  {path: '/texts/', name: 'Texts', component: TextsComponent}
])
export class AppComponent { 
    
}