import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { HomeComponent } from './pages/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    DashboardComponent,
    HomeComponent,
    NavbarComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
  ],
  exports: [
    NavbarComponent,
  ]
})
export class CoreModule { }
