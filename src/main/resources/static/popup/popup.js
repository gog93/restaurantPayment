function showPopup() {
    document.getElementById("myModal").style.display = "block";
}

function closePopup() {
    document.getElementById("myModal").style.display = "none";
}

// Close the popup when the user clicks outside of the content
window.onclick = function(event) {
    var modal = document.getElementById("myModal");
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
