import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { authService } from '../service/authService';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: authService, private router: Router) { }

  canActivate() {
    if (this.authService.isLogged()) {
      this.router.navigate(['/homeLogged']);
    }
    return !this.authService.isLogged();
  }
}