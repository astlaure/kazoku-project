import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './core/pages/dashboard/dashboard.component';
import { AuthGuard } from './auth/guards/auth.guard';
import { HomeComponent } from './core/pages/home/home.component';
import { ProfileResolver } from './auth/resolvers/profile.resolver';

const routes: Routes = [
  {
    path: '',
    resolve: { profile: ProfileResolver },
    children: [
      { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
      { path: '', component: HomeComponent },
    ],
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
