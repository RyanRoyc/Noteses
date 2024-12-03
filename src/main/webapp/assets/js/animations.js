// Smooth animations for notes
document.addEventListener("DOMContentLoaded", () => {
    const notes = document.querySelectorAll(".note");
    notes.forEach(note => {
        note.style.opacity = 0;
        setTimeout(() => {
            note.style.transition = "opacity 1s ease-in-out";
            note.style.opacity = 1;
        }, 300);
    });
});
