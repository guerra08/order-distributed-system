const amqp = require('amqplib');
const { green } = require("colorette");

const QUEUE = "NotificationQueue";
const CONNECTION_STR = "amqp://localhost:5672";

async function main(){
    try {
        console.log(green("Starting Notification Service\n"))
        const connection = await amqp.connect(CONNECTION_STR);
        const channel = await connection.createChannel();
        await channel.assertQueue(QUEUE, { durable: true });
        channel.consume(QUEUE, ( msg => consumeMessage(msg) ), { noAck: true });
    } catch (e) {
        console.error(e);
    }
}

function consumeMessage(msg) {
    const order = JSON.parse(msg.content);
    console.log('Consuming message from Queue.');
    console.log(`Sending notification to ${order.user}, email: ${order.email}\n`)
}

main();