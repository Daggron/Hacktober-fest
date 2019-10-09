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
        theme: new ThemeData(
          primarySwatch: Colors.green,
          brightness: Brightness.light, //if use Brightness.dark it turns into dark theme
          accentColor: Colors.red,
        ),
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
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            new Text(mytext,style: new TextStyle(
              fontSize: 40.0,
              color: Colors.red,
            ),),
            new RaisedButton(
              child: new Text("Click", style: new TextStyle(
                color: Colors.white,
                fontSize: 16.0,
              ),),
              onPressed: _changeText,
              color: Colors.green,
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
          title: new Text("Pulkit ka App"),
        ),
        body:  _bodyWidget(),
        floatingActionButton: new FloatingActionButton(
          child: new Icon(Icons.add),
          onPressed: _changeText,
        ),
      );
    }
}