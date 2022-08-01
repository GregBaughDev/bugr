/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.{html,js,svelte,ts}'],
  theme: {
    colors: {
      'primary': '#240465',
      'background': '#A8F6F1',
    },
    fontFamily: {
      sans: ['Arial', 'sans-serif'],
      serif: ['Times New Roman', 'serif']
    },
    extend: {},
  },
  plugins: [],
}
