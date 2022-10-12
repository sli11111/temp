export const Resize = {
	mounted(el, binding) {
		const handler = binding.value
		const options = {
			passive: !binding.modifiers?.active
		}

		window.addEventListener('resize', handler, options)

		el._onResize = {
			handler,
			options
		}

		if (!binding.modifiers?.quiet) {
			handler()
		}
	},

	activated() {
		const handler = binding.value
		const options = {
			passive: !binding.modifiers?.active
		}

		window.addEventListener('resize', handler, options)

		el._onResize = {
			handler,
			options
		}

		if (!binding.modifiers?.quiet) {
			handler()
		}
	},

	deactivated(el) {
    if (!el._onResize) return

		const { handler, options } = el._onResize
		window.removeEventListener('resize', handler, options)
		delete el._onResize
  },

	unmounted(el) {
		if (!el._onResize) return

		const { handler, options } = el._onResize
		window.removeEventListener('resize', handler, options)
		delete el._onResize
	}
}

export default Resize
