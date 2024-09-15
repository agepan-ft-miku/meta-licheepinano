SUMMARY = "SL(1): Cure your bad habit of mistyping"
SECTION = "examples"
LICENSE = "Original"

### ライセンスファイルには チェックサムが必要
LIC_FILES_CHKSUM = "file://LICENSE;md5=74e9dd589a0ab212a9002b15ef2b82f0"

### git からのソース取得には特定のリビジョンを指定
SRCREV = "923e7d7ebc5c1f009755bdeb789ac25658ccce03"
SRC_URI = "\
	git://github.com/mtoyoda/sl.git \
	file://modify-sl-makefile.patch \
	"

S = "${WORKDIR}/git/"
FILESEXTRAPATHS_prepend := "${THISDIR}:"

### 警告が出るので依存ライブラリを追加
DEPENDS = "ncurses"

do_install() {
             install -d ${D}${bindir}
             install -m 0755 sl ${D}${bindir}
}
