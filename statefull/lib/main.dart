import 'package:flutter/material.dart';

void main(){
  runApp(new Myapp());
}

class Myapp extends StatelessWidget {
  

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: "Statefull App",
      home: new homepage(),
    );
  }
}

class homepage extends StatefulWidget {
  

  _homepageState createState() => _homepageState();
}





class _homepageState extends State<homepage> {

String mytext = "Hello User";

void _changeText(){
setState(() {
  if(mytext.startsWith("H"))
  mytext = "Welcome to my App";
  else
  mytext = "Hello User";
});
}

Widget _bodyWidget() {
  return Container(
    padding: const EdgeInsets.all(8.0),
    child: new Center(
      child: new Column(
        children: <Widget>[
          new Text("Wanna See Magic?"),
          new RaisedButton(
            child: new Text("Click"),
            onPressed: _changeText,
          )
        ],
      ),
    ),
  );
}


  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar:new AppBar(
        title: new Text("Working"),
      ),
      body: new Center(child: new Text("I am not static"),),
    );
  }
}