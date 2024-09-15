SUMMARY = "Example recipe for using inherit useradd"
DESCRIPTION = "This recipe serves as an example for using features from useradd.bbclass"
SECTION = "examples"
PR = "r1"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "\
	file://usb_gadget_config.sh \
	file://storage.img \
	file://kei.png \
    "

S = "${WORKDIR}"

#PACKAGES =+ "${PN}"

do_install () {
	install -d 755 ${D}/etc/init.d/
	install -d 755 ${D}/etc/rcS.d/
	install -d 755 ${D}/media/

	install -m 755 usb_gadget_config.sh ${D}/etc/init.d/
	ln -s /etc/init.d/usb_gadget_config.sh ${D}/etc/rcS.d/S99usb_gadget_config.sh

	install -m 755 storage.img ${D}/media/
	install -m 755 kei.png ${D}/media/
	install -m 755 division.png ${D}/media/
}

FILES_${PN} = "\
	/etc/init.d/usb_gadget_config.sh \
	/etc/rcS.d/S99usb_gadget_config.sh \
	/media/storage.img \
	/media/kei.png \
	/media/division.png \
	"
