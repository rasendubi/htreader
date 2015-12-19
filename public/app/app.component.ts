import {Component} from 'angular2/core';

@Component({
    selector: 'my-app',
    template: `
    <div class="row" id="main">
        <div class="col-md-3" id="leftpanel">
            <a [routerLink]="['Dashboard']">Dashboard</a>
            <a [routerLink]="['Heroes']">Heroes</a>
            <router-outlet></router-outlet>
        </div>
        <div class="col-md-9" id="rightpanel">Right panel</div>
    </div>
    `,
    styleUrls: [
        'node_modules/bootstrap/dist/css/bootstrap.css',
        'app/app.component.css'
    ]
})
export class AppComponent { 
    
}