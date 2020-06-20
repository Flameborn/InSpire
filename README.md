# InSpire

A mod for Slay the Spire that provides access to the game for blind and visually impaired gamers under Windows.

## Installation

The installation steps are currently for Steam. Other versions from non-Steam distributors were not tested, but theoretically InSpire should work with those as well.

You will need the following requirements:

* [Steam for Windows](https://steamcdn-a.akamaihd.net/client/installer/SteamSetup.exe)
* [Slay the Spire](https://store.steampowered.com/app/646570/Slay_the_Spire/)
* [Java JRE](https://www.oracle.com/java/technologies/javase-jre8-downloads.html)
* [BaseMod](https://steamcommunity.com/workshop/filedetails/?id=1605833019)
* [ModTheSpire](https://steamcommunity.com/sharedfiles/filedetails/?id=1605060445)
* [Communication Mod](https://steamcommunity.com/sharedfiles/filedetails/?id=2131373661)

If you care about your achievements, and why wouldn't you, be sure to grab [Achievement Enabler](https://steamcommunity.com/sharedfiles/filedetails/?id=1692554109). Please be nice and don't use this mod with mods that make the game easier.

Finally, grab an InSpire [release](https://github.com/flameborn/InSpire/releases), or compile from source (see below).

The dll files should go into the *root* directory of the game, while the jar file should be located in a *mods* directory in the root. Feel free to create this directory if it does not exist.

InSpire uses a screen reader for speech output. If a supported one is not available, the mod will fall back to Microsoft's Speech API.

Communication between InSpire and an available speech driver is via Davy Kager's [Tolk](https://github.com/dkager/tolk) library.

## Compiling from source

The requirements are mostly the same, but in order to compile, you should get the [Java JDK](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html) instead.

To build and package the mod, you will also need [Maven](https://maven.apache.org/download.cgi)

Alternatively, you can use [Chocolatey](https://chocolatey.org/install).

After cloning this repository:

Open up a command line prompt and type:

```
mvn package
```

If the build is successful, the jar file will be automagically copied to your *mods* directory. Additionally, you will need to copy the included dll files from *lib* to the root directory of the game.

*NOTE*: the default *pom.xml* file of this repository is set up to contain the default Steam and mod paths from the workshop. Please make sure that you don't include this in your pull requests, if you modify it to your taste.

## Contributing

Contributions of any kind are more than welcome. Feel free to submit a new [issue](https://github.com/flameborn/InSpire/issues/new), or a [pull request](https://github.com/flameborn/InSpire/pull/new). Thanks in advance for making STS access better!

## InSpire Contributors

* [Flameborn](https://github.com/flameborn)

## FAQ

### This is nice and all, but wouldn't this be better in the actual game?

Most definitely. Unfortunately, Mega Crit, despite multiple attempts from multiple people to reach out, including the author of this mod, remained consistently silent, even when offered to implement the a11y features.

If you would like to help, feel free to contact them (nicely), and point them in the direction of this mod. Implementing accessibility in the game is the best way of ensuring that anyone can enjoy the game without barriers.

### Why Windows only?

Due to Apple's app notarization requirements, the upcoming 2.1 version of STS will not support mods. This means that I won't be able to support MacOS.

Linux at the moment is not my operating system of choice for daily use, hence the mod does not support it. Having said that, it should be possible to make things work via Speech Dispatcher. Contributions to support this are welcome.

## Special Thanks

* [Mega Crit](https://www.megacrit.com/) for a great and very addictive game.
* [@ForgottenArbiter](https://github.com/ForgottenArbiter) for [CommunicationMod](https://github.com/ForgottenArbiter/CommunicationMod), as well as believing in InSpire
* [@Wensber](https://github.com/Wensber) for [TextTheSpire](https://github.com/Wensber/TextTheSpire), which started it all
* [@Pitermach](https://github.com/pitermach), who Auto(It)mated what started it all, via [ReadTheSpire](https://github.com/pitermach/readthespire)
* [@daviscook477](https://github.com/daviscook477), the current maintainer of [Basemod](https://github.com/daviscook477/BaseMod)
* [@kiooeht](https://github.com/kiooeht) for [ModTheSpire](https://github.com/kiooeht/ModTheSpire)
* And thanks to any past, present or future modders. I am glad to be part of such a vibrant community.
