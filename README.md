# InSpire

A mod for Slay the Spire that provides access to the game for blind and visually impaired gamers under Windows and MacOS.

## Installation

The installation steps are currently for Steam. Other versions from non-Steam distributors were not tested, but theoretically InSpire should work with those as well.

You will need the following requirements:

* Steam for [Windows](https://steamcdn-a.akamaihd.net/client/installer/SteamSetup.exe) or [MacOS](https://steamcdn-a.akamaihd.net/client/installer/steam.dmg)
* [Slay the Spire](https://store.steampowered.com/app/646570/Slay_the_Spire/)
* [Java JRE](https://www.oracle.com/java/technologies/javase-jre8-downloads.html)
* [BaseMod](https://steamcommunity.com/workshop/filedetails/?id=1605833019)
* [ModTheSpire](https://steamcommunity.com/sharedfiles/filedetails/?id=1605060445)
* [Communication Mod](https://steamcommunity.com/sharedfiles/filedetails/?id=2131373661)

If you care about your achievements, and why wouldn't you, be sure to grab [Achievement Enabler](https://steamcommunity.com/sharedfiles/filedetails/?id=1692554109). Please be nice and don't use this mod with mods that make the game easier.

Finally, grab an InSpire [release](https://github.com/flameborn/InSpire/releases), or compile from source (see below).

The downloaded *jar* file should be copied to a *mods* directory in the root of the game.

Under Windows, this is: *C:/Program Files (x86)/Steam/steamapps/common/SlayTheSpire*

Under MacOS, it's: *~/Library/Application Support/Steam/steamapps/common/SlayTheSpire/SlayTheSpire.app/Contents/Resources

(Note: You need to choose *Show Package Contents* from the context menu to access the contents of *SlayTheSpire.app*)

Feel free to create the *mods* directory if it does not exist.

Under Windows, InSpire uses a screen reader for speech output. If a supported one is not available, the mod will fall back to Microsoft's Speech API.

Communication between InSpire and an available speech driver is via Davy Kager's [Tolk](https://github.com/dkager/tolk) library.

InSpire will attempt to extract Tolk and its helper libraries to the game's root directory when needed.

Under MacOS, InSpire will attempt to use the built-in *say* utility.

## Compiling from source

The requirements are mostly the same, but in order to compile, you should get the [Java JDK](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html) instead of the JRE.

To build and package the mod, you will also need [Maven](https://maven.apache.org/download.cgi)

Alternatively, you can use [Chocolatey](https://chocolatey.org/install) under Windows, or [Homebrew](https://brew.sh/) under MacOS to install these packages faster.

After cloning this repository, open up a command line prompt and type:

```
mvn package
```

If the build is successful, the jar file will be automagically copied to your *mods* directory.

*NOTE*: the default *pom.xml* file of this repository is set up to contain the default Steam and mod paths from the workshop. Feel free to modify it, should your paths differ, however, please make sure that you *do not* include this in your pull requests.

## Keyboard shortcuts

Please note: InSpire provides a set of shortcuts to enhance game accessibility. These shortcuts are currently not remappable. Assigning existing STS actions to InSpire keys may result in unwanted behaviour.

* *Enter*: By default, it activates the selected item. Alternatively, it performs the selected action for the current item, or the default action for the current screen. It also allows certain screens to be skipped, such as the splash screen.
* *Shift+Enter*: Cycles between available actions.
* *Home*: Moves to the first item on the current screen.
* *End*: Moves to the last item on the current screen.
* *Up/Down arrows*: Moves to the previous and next item on the current screen. respectively.
* *Left/Right arrows*: Moves between the various items of a selected item, e.g. moves between list items of a list, or adjusts sliders.

## Contributing

Contributions of any kind are more than welcome. Feel free to submit a new [issue](https://github.com/flameborn/InSpire/issues/new), or a [pull request](https://github.com/flameborn/InSpire/pull/new). Thanks in advance for making STS access better!

### InSpire Contributors

* [Flameborn](https://github.com/flameborn)

## FAQ

### This is nice and all, but wouldn't this be better in the actual game?

Most definitely. Unfortunately, Mega Crit believes that adding accessibility features on top of the game is better to do in a mod.

I believe that implementing accessibility in the game is the best way of ensuring that anyone can enjoy the game without barriers, since:

* Accessibility features that this mod provides would be available out of the box, without having to install, or rely on, additional mods. In addition, accessibility features would be likely available on platforms where modding is currently not possible, such as on iOS.
* Game updates would not break accessibility. STS updates are known to be released quite often. Even though the authors of this mod did everything possible to minimise chances, but changes to the core game could potentially render parts of, or the complete InSpire (or the required mod packages) unusable until a new, fixed version is posted.

### Why Windows and Mac only?

Linux at the moment is not my operating system of choice for daily use, hence the mod does not support it. Having said that, it should be possible to make things work via Speech Dispatcher. Contributions to support this are welcome.

### Why are you using the 'say' utility? Isn't that a bit inefficient when NSSpeechSynthesizer is available?

Yes, and no. Java currently cannot use objective C classes directly. Although bridges exist, they rely on an external dynamic library (dylib), which would need signing and notarization in order to run.

Since Apple's developer license is not free, and it is an annual price, covering this cost would require continuous funding. Asking Mac users of InSpire for continuous payment while access is theoretically provided for free on other platforms would be unfair. Using *say* is currently the best option.

### How is InSpire different when compared to TextTheSpire?

It is important to note that InSpire was not born to replace TextTheSpire.

InSpire is meant to provide an alternative, perhaps a bit more mainstream, way to access the game, which does not rely on text commands. If you don't like this, or you would like to play Slay the Spire in the style of a text game instead, TextTheSpire is for you!

## Special Thanks

* [Mega Crit](https://www.megacrit.com/) for a great and very addictive game.
* [@ForgottenArbiter](https://github.com/ForgottenArbiter) for [CommunicationMod](https://github.com/ForgottenArbiter/CommunicationMod), as well as believing in InSpire
* [@Wensber](https://github.com/Wensber) for [TextTheSpire](https://github.com/Wensber/TextTheSpire), which started it all
* [@Pitermach](https://github.com/pitermach), who Auto(It)mated what started it all, via [ReadTheSpire](https://github.com/pitermach/readthespire)
* [@daviscook477](https://github.com/daviscook477), the current maintainer of [Basemod](https://github.com/daviscook477/BaseMod)
* [@kiooeht](https://github.com/kiooeht) for [ModTheSpire](https://github.com/kiooeht/ModTheSpire)
* And thanks to any past, present or future modders. I am glad to be part of such a vibrant community.

## STS supports the Steam Workshop. Are there plans to publish InSpire there?

Absolutely. Once InSpire reaches a stable version, it will be published there as well. Binary releases will be still available here, in case you are using a non-Steam version.

## How can I keep up with updates?

Simply subscribe to releases via the *watch* feature.