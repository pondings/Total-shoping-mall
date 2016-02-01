'use strict';

/** WMS App module */
angular.module('app', [
/* common modules */
'app.core', 'app.widgets',
/* Feature modules */
'app.store' ]);
/* validate */

/* Store */
angular.module('app.emp', [ 'app.core', 'app.widgets', 'jcs-autoValidate' ])
		.run([ 'validator', function(validator) {
			validator.setValidElementStyling(false);
		} ]);

/* require module */
angular.module('app.core', [
/* Angular modules... */
/* Cross-app modules... */
/* 3rd-party module */
'ui.router' ]);

var app = angular.module('app.widgets', [ 'ui.bootstrap',
		'picardy.fontawesome', 'ngBootbox', 'oitozero.ngSweetAlert', 'flash',
		'wt.responsive', 'smart-table' ]);