// Form validation logic
document.addEventListener("DOMContentLoaded", () => {
    const forms = document.querySelectorAll("form");
    forms.forEach(form => {
        form.addEventListener("submit", e => {
            const inputs = form.querySelectorAll("input, textarea");
            let isValid = true;
            inputs.forEach(input => {
                if (!input.value.trim()) {
                    input.style.borderColor = "red";
                    isValid = false;
                } else {
                    input.style.borderColor = "green";
                }
            });
            if (!isValid) e.preventDefault();
        });
    });
});
