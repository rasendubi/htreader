import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES} from 'angular2/router';
import {CardsComponent} from './cards.component';
import {ExtractsComponent} from './extracts.component';
import {ArticlesComponent} from './articles.component';
import {ArticleComponent} from './article.component';
import {NewCardComponent} from './newcard.component';

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
  {path: '/articles/', name: 'Articles', component: ArticlesComponent},
  {path: '/newcard/', name: 'NewCard', component: NewCardComponent},
  {path: '/article/:id', name: 'Article', component: ArticleComponent}
])
export class AppComponent { }