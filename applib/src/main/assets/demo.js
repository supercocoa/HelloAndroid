//require
// load('ArrayList, UIColor, UISlider, NSIndexPath');
// load('java.util.ArrayList');

var TAG = "demo.js";

log(TAG, "12321321312321321");
log(TAG, typeof  "1231321");

var str = new String("string object")
log(TAG, str);

// Invoke class method
var arraylist = newObject("java.util.ArrayList");
arraylist.add(newInt(1));
arraylist.add(newInt(2));
log(TAG, arraylist.size());


// Invoke instance method
// var view = UIView.alloc().init();
// view.setNeedsLayout();

// // set proerty
// view.setBackgroundColor(redColor);
//
// // get property
// var bgColor = view.backgroundColor();
//
// // multi-params method (use underline to separate)
// // OC：NSIndexPath *indexPath = [NSIndexPath indexPathForRow:0 inSection:1];
// var indexPath = NSIndexPath.indexPathForRow_inSection(0, 1);
//
// // method name contains underline (use double undeline to represent)
// // OC: [JPObject _privateMethod];
// JPObject.__privateMethod()
//
// // use .toJS() to convert NSArray / NSString / NSDictionary to JS type.
// var arr = require('NSMutableArray').alloc().init()
// arr.addObject("JS")
// jsArr = arr.toJS()
// console.log(jsArr.push("Patch").join(''))  //output: JSPatch
//
// // use hashes to represent struct like CGRect / CGSize / CGPoint / NSRange
// var view = UIView.alloc().initWithFrame({x:20, y:20, width:100, height:100});
// var x = view.bounds().x;