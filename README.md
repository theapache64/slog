![](cover.jpeg)

# 🪵 slog

![buildStatus](https://img.shields.io/github/workflow/status/theapache64/slog/Java%20CI%20with%20Gradle?style=plastic)
![latestVersion](https://img.shields.io/github/v/release/theapache64/slog)
<a href="https://twitter.com/theapache64" target="_blank">
<img alt="Twitter: theapache64" src="https://img.shields.io/twitter/follow/theapache64.svg?style=social" />
</a>

> GoogleSheet based Logging Library for Android, iOS, JVM and JS

### ✨ Demo

```kotlin
Slog.d { "Your log message goes here" }
```


## ⌨️ Usage

1. Create a Google form with `message` field, link the form with Google Sheet and copy the public URL

![image](https://github.com/user-attachments/assets/93184b12-01d6-45a4-b71a-d234bd93cfc9)

![image](https://github.com/user-attachments/assets/4b4cfdf9-777f-4183-a191-f70ff683648f)



2. Install the dependency

![latestVersion](https://img.shields.io/github/v/release/theapache64/slog)

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.theapache64:slog:<latest.version>")
}
```

3. Init the library and pass the Google form link

```kotlin
Slog.init(formUrl = "https://docs.google.com/forms/d/e/32423sdfsd6757/viewform?usp=dialog")
```

4. Finally, start logging 🚀

```kotlin
Slog.d { "Your Log Goes Here" }
```


## ✍️ Author

👤 **theapache64**

* Twitter: <a href="https://twitter.com/theapache64" target="_blank">@theapache64</a>
* Email: theapache64@gmail.com

Feel free to ping me 😉

## 🤝 Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Open an issue first to discuss what you would like to change.
1. Fork the Project
1. Create your feature branch (`git checkout -b feature/amazing-feature`)
1. Commit your changes (`git commit -m 'Add some amazing feature'`)
1. Push to the branch (`git push origin feature/amazing-feature`)
1. Open a pull request

Please make sure to update tests as appropriate.

## ❤ Show your support

Give a ⭐️ if this project helped you!

<a href="https://www.buymeacoffee.com/theapache64" target="_blank">
    <img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" width="160">
</a>


## 📝 License

```
Copyright © 2025 - theapache64

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

_This README was generated by [readgen](https://github.com/theapache64/readgen)_ ❤
