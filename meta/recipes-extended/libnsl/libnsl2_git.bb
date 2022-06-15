# Copyright (C) 2017 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Library containing NIS functions using TI-RPC (IPv6 enabled)"
DESCRIPTION = "This library contains the public client interface for NIS(YP) and NIS+\
               it was part of glibc and now is standalone packages. it also supports IPv6"
HOMEPAGE = "https://github.com/thkukuk/libnsl"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"
SECTION = "libs"
DEPENDS = "libtirpc"

PV = "1.3.0"

SRCREV = "fbad7b36acaa89a54023930af70805649f962999"

SRC_URI = "git://github.com/thkukuk/libnsl;branch=master;protocol=https \
           file://libnsl2_libs.conf \
          "

S = "${WORKDIR}/git"

inherit autotools pkgconfig gettext

BBCLASSEXTEND = "native nativesdk"
EXTRA_OECONF += "--libdir=${libdir}/nsl --includedir=${includedir}/nsl"

do_install_append() {
	install -d ${D}${libdir}
	mv ${D}${libdir}/nsl/pkgconfig ${D}${libdir}

	install -d ${D}${sysconfdir}/ld.so.conf.d/
	install -m 0644 ${WORKDIR}/libnsl2_libs.conf ${D}${sysconfdir}/ld.so.conf.d/
}

FILES_${PN} += "${libdir}/nsl/*.so.* ${sysconfdir}/ld.so.conf.d/libnsl2_libs.conf"
FILES_${PN}-dev += "${includedir}/nsl ${libdir}/nsl/*.so"
FILES_${PN}-staticdev += "${libdir}/nsl/*.a"
