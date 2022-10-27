import { Component } from '@angular/core'

@Component({
	selector: 'app-header',
	template: `
		<mat-toolbar color="primary">
			<span>
				<a routerLinkActive="active" routerLink="/">
					<button mat-mini-fab color="primary">
						<mat-icon>home</mat-icon>
					</button>
				</a>
			</span>
			<span class="padding">
				{{ appTitle }}
			</span>
		</mat-toolbar>
	`,
	styleUrls: [ './header.component.css' ]
})
export class HeaderComponent {
	appTitle = "Survey Manager"
}
