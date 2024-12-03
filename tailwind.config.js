/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,js,jsx,ts,tsx}",
    "./node_modules/flowbite/**/*.js", // Include flowbite's content
  ],
  theme: {
    extend: {},
  },
  plugins: [
    require('flowbite/plugin'), // Add flowbite plugin here
  ],
  darkMode:"selector"
}

