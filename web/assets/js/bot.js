
function sendMessage() {
  const input = document.getElementById("chat-input");
  const message = input.value.trim();
  if (!message) return;

  const chatMessages = document.getElementById("chat-messages");
  chatMessages.innerHTML += `<div><strong>Bạn:</strong> ${message}</div>`;

  fetch("bot", {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" },
    body: "message=" + encodeURIComponent(message)
  })
  .then(res => res.json())
  .then(data => {
    chatMessages.innerHTML += `<div><strong>Bot:</strong> ${data.reply}</div>`;
    input.value = "";
    chatMessages.scrollTop = chatMessages.scrollHeight;
  });
}
