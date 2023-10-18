package com.studeo.playgroung.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.PermissionRequest
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.studeo.staging.playgroung.R
import com.studeo.staging.playgroung.databinding.FragmentChallengeBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [chat.newInstance] factory method to
 * create an instance of this fragment.
 */
class chat : Fragment() {

    private var _binding: FragmentChallengeBinding? = null

    private val CAMERA_REQUEST_CODE = 100

    private fun requestCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf<String>(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        } else {
            // La permission est déjà accordée
        }
    }
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var mWebView: WebView? = null

    private val RECORD_AUDIO_PERMISSION_CODE = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentChallengeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        mWebView = root.findViewById<View>(R.id.webview) as WebView
        //mWebView!!.webViewClient = MyWebViewClient()

// Configurer le WebViewClient pour gérer les URL

// Configurer le WebViewClient pour gérer les URL
        mWebView!!.setWebViewClient(WebViewClient())
        WebView.setWebContentsDebuggingEnabled(true)

// Configurer le WebChromeClient pour gérer les demandes de permissions
        mWebView!!.setWebChromeClient(object : WebChromeClient() {
            override fun onPermissionRequest(request: PermissionRequest) {
                activity!!.runOnUiThread(Runnable { request.grant(request.resources) })
            }
        })




    // Handle permission request result


        //mWebView!!.loadUrl("http://10.0.2.2:3010/flashcard-standalone/123?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoyNjE5NSwiaWF0IjoxNjk0Njc0MjMwfQ.Kayrb7ubIhZwM5NeusXtMo01z_TCtdiiM-uKZDD_WH4")
        //mWebView!!.loadUrl("https://847a-93-19-149-176.ngrok-free.app/chat-standalone?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjozMDE5OCwiaWF0IjoxNjk2MjM3MzI1fQ.T2ZlVtim2lf9Y0j9Wa3zCbFdrndB2n51eYnOeqbBZH0")

        mWebView!!.loadUrl("https://solver.staging.studeo.group/flashcard-standalone/29?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjozMDE5OCwiaWF0IjoxNjk3NjI2ODI0fQ.EzYODpjv4X3VhM-kn_QczkuRDMBC-q0mDSnoPc6vf8o")
        //mWebView!!.loadUrl("https://solver.staging.studeo.group/flashcard-standalone/107?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjozMDMzNSwiaWF0IjoxNjk3MDU5NjYxfQ.urFSrD2B1gPYbQ0Dp0DiDUfzMKnDAUm2QyLhoQCdnhc");
        //mWebView!!.loadUrl("http://10.0.2.2:3010/chat-standalone?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjozMDE5OCwiaWF0IjoxNjk2MjM3MzI1fQ.T2ZlVtim2lf9Y0j9Wa3zCbFdrndB2n51eYnOeqbBZH0")
        //mWebView!!.loadUrl("https://solver.staging.studeo.group/chat-standalone?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjozMDE5OCwiaWF0IjoxNjk2MjM3MzI1fQ.T2ZlVtim2lf9Y0j9Wa3zCbFdrndB2n51eYnOeqbBZH0&gameNameList=dailyChallenge")

        //mWebView!!.loadUrl("http://10.0.2.2:3010")
        //mWebView!!.loadUrl("https://0138-2001-861-8c98-de10-ac42-f79e-21d8-b481.ngrok-free.app/flashcard-standalone/123?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoyNjE5NSwiaWF0IjoxNjk0Njc0MjMwfQ.Kayrb7ubIhZwM5NeusXtMo01z_TCtdiiM-uKZDD_WH4")
        //mWebView!!.loadUrl("https://solver.staging.studeo.group/flashcard-standalone/123?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjozMDMzNSwiaWF0IjoxNjk0NTkzNzAxfQ.lg5FBJbHutXtkEyd6UTUjTF3F_LG-_pqt8gqdgqoBzY");
        //mWebView!!.loadUrl("https://google.com")

        // Enable Javascript

        // Enable Javascript
        val webSettings: WebSettings = mWebView!!.getSettings()
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true;
        mWebView!!.clearView();
        mWebView!!.measure(100, 100);
        webSettings.useWideViewPort = true;
        webSettings.loadWithOverviewMode = true;

        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);

        // Force links and redirects to open in the WebView instead of in a browser

        // Force links and redirects to open in the WebView instead of in a browser
        //mWebView!!.webViewClient = WebViewClient()



        return root
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // La permission de la caméra a été accordée
                } else {
                    // La permission de la caméra a été refusée
                }
                return
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}