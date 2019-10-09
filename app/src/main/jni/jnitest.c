#include "JNIUtils_JNIUtils.h"
/* *
Class:     io_github_yanbober_ndkapplication_NdkJniUtils
 * Method:    getCLanguageString
* Signature: ()Ljava/lang/String;
*/

JNIEXPORT jstring JNICALL Java_JNIUtils_JNIUtils_getStringFormA (JNIEnv *env, jobject obj){
return (*env)->NewStringUTF(env,"aHR0cDovL3d3dy50YWlkYWdhbmcuY29tL0pML2FiYw");
}
JNIEXPORT jstring JNICALL Java_JNIUtils_JNIUtils_getStringFormB (JNIEnv *env, jobject obj){
return (*env)->NewStringUTF(env,"ZDQxMGE2ZDQ1NmNkMTdjNA");
}
JNIEXPORT jstring JNICALL Java_JNIUtils_JNIUtils_getStringFormC (JNIEnv *env, jobject obj){
return (*env)->NewStringUTF(env,"N2QwZTAzOTkxNjdmYzY3ZA");
}
JNIEXPORT jstring JNICALL Java_JNIUtils_JNIUtils_getStringFormD (JNIEnv *env, jobject obj){
    return (*env)->NewStringUTF(env,"eHl4LkJU");
 }