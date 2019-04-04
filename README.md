### StartActivityForResultHelper

一个轻巧的,用于解耦startActivityForResult方法的库。

### 引入

gradle 依赖 ：

``` 
implementation com.github.lesincs:StartActivityForResultHelper:1.0.0
```

### 使用

start：

```
Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
StartActivityForResultHelper.startActivityForResult(FirstActivity.this, intent, new ActivityResultCallback() {
  @Override
  public void onResult(int resultCode, Intent intent) {
    Log.d(TAG,"resultCode = " + resultCode );
    Log.d(TAG,"data = " + intent.getStringExtra(Constants.EXTRA_KEY));
  }
});
```

finish：

```
Intent intent = new Intent();
intent.putExtra(Constants.EXTRA_KEY,"DATA");
setResult(Constants.RESULT_CODE,intent);
finish();
```

### 特性

* 无需重写``OnActivityResult方法``,减少代码耦合
* 不需要关注``REQUEST_CODE``
* 支持``Activity``和``Fragment``
* 体积小巧,没有引用多余的第三方库

### License

```
Copyright 2019 lesincs

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```