buildReceipt = (order) => {
    return `Order ${order.id}\nItems: ${order.items}\nPrice: ${order.price}\nDate: ${Date.now()}`;
}

module.exports = {
    buildReceipt
}