import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'WebSocketClient';
  stock: any = {};
  indicator : string = '▲';
  messages: string[] = [];

  private webSocket: WebSocket;

  constructor() {
    this.webSocket = new WebSocket('ws://localhost:8080/stocks');
    this.webSocket.onmessage = (event) => {
      this.messages.push(event.data);
      this.stock = JSON.parse(event.data)
    };
  } 
}
