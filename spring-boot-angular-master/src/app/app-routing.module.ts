import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from "src/app/app.component";
const routes: Routes = [
    { path: 'index', component: AppComponent }
];
@NgModule( {
    imports: [RouterModule.forRoot( routes )],
    exports: [RouterModule],
    declarations: [],

} )
export class AppRoutingModule { }
