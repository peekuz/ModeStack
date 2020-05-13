import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { Observable } from "rxjs";

@Component( {
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
} )
export class AppComponent {
    model: any = {};
    title = 'Demo';
    data = {};
    constructor( private http: HttpClient, private route: ActivatedRoute,
        private router: Router,
    ) {
      //  http.get( 'resource' ).subscribe( data => this.data = data );
    }

    ngOnInit() {
        sessionStorage.setItem( 'token', '' );
    }

    login() {
        let url = '/login';
        this.http.post<Observable<boolean>>(url, {
            userName: this.model.username,
            password: this.model.password
        }).subscribe(isValid => {
            if (isValid) {
                sessionStorage.setItem(
                  'token', 
                  btoa(this.model.username + ':' + this.model.password)
                );
            this.router.navigate(['']);
            } else {
                alert("Authentication failed.")
            }
        });
    }
}
