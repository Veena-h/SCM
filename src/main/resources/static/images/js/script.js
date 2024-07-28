console.log("hello world");

let currentTheme = getTheme();
console.log(currentTheme);

document.addEventListener("DOMContentLoaded" ,() =>
{


changeTheme();

});



function changeTheme() {
  document.querySelector("html").classList.add(currentTheme);

  const changeThemeButton = document.querySelector('#theme_change');
  changeThemeButton.querySelector("span").textContent =
    currentTheme == "light" ? "dark" : "light";

  changeThemeButton.addEventListener("click", (event) => {
    console.log("change theme button clicked");

    // Remove the current theme
    document.querySelector("html").classList.remove(currentTheme);

    // Toggle the theme
    if (currentTheme == "dark") {
      currentTheme = "light";
    } else {
      currentTheme = "dark";
    }

    // Set the new theme
    setTheme(currentTheme);

    // Add the new theme
    document.querySelector("html").classList.add(currentTheme);

    // Update the button text
    changeThemeButton.querySelector("span").textContent =
      currentTheme == "light" ? "dark" : "light";
  });
}

// Set theme
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

// Get theme
function getTheme() {
  let theme = localStorage.getItem("theme");
  // If theme is not set, return light
  return theme ? theme : "light";
}
