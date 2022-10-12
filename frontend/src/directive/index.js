import { Resize } from './Resize'

const directives = {
	Resize
}

export default {
	install(app) {
		Object.keys(directives).forEach((key) => {
			app.directive(key, directives[key])
		})
	}
}
